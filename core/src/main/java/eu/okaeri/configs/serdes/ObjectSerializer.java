package eu.okaeri.configs.serdes;

import eu.okaeri.configs.schema.GenericsDeclaration;
import lombok.NonNull;

public interface ObjectSerializer<T> {

    /**
     * Magic value representing the name of the key which allows
     * to replace the serialization result with the custom object.
     *
     * <strong>Warning: DO NOT USE 'THE STRING' DIRECTLY</strong>
     *
     * Example serialization:
     * - serializationData.addCollection(VALUE, Arrays.asList("my", "list"), String.class);
     *
     * Example deserialization:
     * - deserializationData.getAsList(VALUE, String.class)
     */
    String VALUE = "$$__value__$$";

    /**
     * @param type the type checked for compatibility
     * @return {@code true} if serializer is able to process the {@code type}
     */
    boolean supports(@NonNull Class<? super T> type);

    /**
     * @param object   the object to be serialized
     * @param data     the serialization data
     * @param generics the generic information about the {@code object}
     */
    void serialize(@NonNull T object, @NonNull SerializationData data, @NonNull GenericsDeclaration generics);

    /**
     * @param data     the source deserialization data
     * @param generics the target generic type for the {@code data}
     * @return the deserialized object
     */
    T deserialize(@NonNull DeserializationData data, @NonNull GenericsDeclaration generics);
}
