package com.dinzeer.legendblade.item;
import com.dinzeer.legendblade.Legendblade;
import com.tterrag.registrate.providers.RegistrateLangProvider;


import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;

import javax.annotation.Nullable;
import java.util.Locale;

import static com.dinzeer.legendblade.Legendblade.MODID;

public class LangData {

    public enum IDS {
        // 枚举常量定义
        BANNED("tooltip.misc.banned", "This item is disabled.", 0),
        BANNED_ENCH("tooltip.misc.banned_ench", "Disabled", 0),
        ARMOR_CORE("tooltip.item.armor_core_desc", "§7Used to load forging templates", 0),
        ITEMS_TAB_LANG("tab.template_maker","Template Maker Items",0),
        AMETHYST_BRONZE("tooltip.item.amethyst_bronze", "§aResonance §7providing 10% magic protection effect",0 );

        // 字段声明
        final String id, def;
        final int count;

        // 构造方法
        IDS(String id, String def, int count) {
            this.id = id;
            this.def = def;
            this.count = count;
        }

        public MutableComponent get(Object... objs) {
            if (objs.length != count)
                throw new IllegalArgumentException("for " + name() + ": expect " + count + " parameters, got " + objs.length);
            return translate(MODID + "." + id, objs);
        }
    }

        public interface LangEnum<T extends Enum<T> & LangEnum<T>> {

            int getCount();

            @Nullable
            default Class<? extends Enum<?>> mux() {
                return null;
            }

            @SuppressWarnings({"unchecked"})
            default T getThis() {
                return (T) this;
            }

        }


        public static String asId(String name) {
            return name.toLowerCase(Locale.ROOT);
        }

        public static MutableComponent translate(String key, Object... objs) {
            return Component.translatable(key, objs);
        }

}
