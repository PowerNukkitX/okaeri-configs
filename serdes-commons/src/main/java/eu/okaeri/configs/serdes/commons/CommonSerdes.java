package eu.okaeri.configs.serdes.commons;

import eu.okaeri.configs.serdes.OkaeriSerdesPack;
import eu.okaeri.configs.serdes.TransformerRegistry;

// types that exceed standard typeset
public class CommonSerdes implements OkaeriSerdesPack {

    @Override
    public void register(TransformerRegistry registry) {
        registry.register(new PatternTransformer());
        registry.register(new InstantTransformer());
    }
}