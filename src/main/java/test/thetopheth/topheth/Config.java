package test.thetopheth.topheth;

import net.neoforged.neoforge.common.ModConfigSpec;

public class Config {
    // Спецификация конфига (обязательно public static final!)
    public static final ModConfigSpec SPEC;
    
    // Параметры конфигурации (примеры)
    public static final ModConfigSpec.BooleanValue ENABLE_FEATURE;
    public static final ModConfigSpec.IntValue MAX_ITEMS;

    // Статический блок инициализации
    static {
        ModConfigSpec.Builder builder = new ModConfigSpec.Builder();
        
        // Добавляем настройки
        ENABLE_FEATURE = builder
            .comment("Включить фичу мода")
            .define("enableFeature", true); // Значение по умолчанию
        
        MAX_ITEMS = builder
            .comment("Максимальное количество предметов")
            .defineInRange("maxItems", 10, 1, 100); // min=1, max=100
        
        SPEC = builder.build();
    }
}