package fi.dy.masa.tweakeroo.config;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import fi.dy.masa.malilib.config.ConfigType;
import fi.dy.masa.malilib.config.IConfigBoolean;
import fi.dy.masa.malilib.config.IConfigNotifiable;
import fi.dy.masa.malilib.config.IHotkeyTogglable;
import fi.dy.masa.malilib.gui.GuiBase;
import fi.dy.masa.malilib.hotkeys.IKeybind;
import fi.dy.masa.malilib.hotkeys.KeyCallbackToggleBooleanConfigWithMessage;
import fi.dy.masa.malilib.hotkeys.KeybindMulti;
import fi.dy.masa.malilib.hotkeys.KeybindSettings;
import fi.dy.masa.malilib.interfaces.IValueChangeCallback;
import fi.dy.masa.malilib.util.StringUtils;
import fi.dy.masa.tweakeroo.Tweakeroo;

public enum FeatureToggle implements IHotkeyTogglable, IConfigNotifiable<IConfigBoolean>
{
    CARPET_ACCURATE_PLACEMENT_PROTOCOL ("carpetAccuratePlacementProtocol",  false, "",    "如果启用本功能，则Flexible Block Placemen和\nAccurate Block Placement将会使用最新的\n通过CarpetMod实现的协议", "Carpet protocol Accurate Placement"),
    FAST_PLACEMENT_REMEMBER_ALWAYS  ("fastPlacementRememberOrientation",    true, "",     "如果启用，则 FastPlacement 将始终记住您\n放置的第一个方块的方向\n如果没有此设置，则只有在启用并且\n应用了Flexible Placement的情况下才能记住方向", "Fast Placement Remember Orientation"),
    REMEMBER_FLEXIBLE               ("rememberFlexibleFromClick",           true, "",     "当该选项开启时，按住使用键时第一个放置的方块的\n放置状态（如方向）将会被用于之后放置的方块", "Remember Flexible Orientation From First Click"),
    TWEAK_ACCURATE_BLOCK_PLACEMENT  ("tweakAccurateBlockPlacement",         false, "",    "启用一个更简单的“灵活放置”版本，类似于\ncarpet mod，因此基本上可以从单击的方块面,面向内或从\n面向外。按住热键。"),
    TWEAK_AFTER_CLICKER             ("tweakAfterClicker",                   false, "",    KeybindSettings.INGAME_BOTH, "开启 After clicker 功能, 会在放置方块后自动点击右键.\n举个栗子：中继器设置延迟）\n要快速调整单击次数，请在按住热键的同时滚动滚轮"),
    TWEAK_AIM_LOCK                  ("tweakAimLock",                        false, "",    "锁定你的视角到任意一个值\n与SnapAimLock不同"),
    TWEAK_ANGEL_BLOCK               ("tweakAngelBlock",                     false, "",    "在创造模式下可以在空中放置方块"),
    TWEAK_BLOCK_REACH_OVERRIDE      ("tweakBlockReachOverride",             false, "",    "调整你手能够到的长度\n在 通用设置 -> blockReachDistance设置\nWarning>>经过 闪电小绿 实测，会产生大量隐形方块"),
    TWEAK_BREAKING_GRID             ("tweakBreakingGrid",                   false, "",    KeybindSettings.INGAME_BOTH, "[机翻]启用后，您只能以可配置的间隔中断\n网格模式中的块。\n要快速调整间隔，请在按住热键的同时滚动滚轮"),
    TWEAK_BREAKING_RESTRICTION      ("tweakBreakingRestriction",            false, "",    "启用>方块破坏限制模式<\n  (Plane, Layer, Face, Column, Line, Diagonal).\n你按下左键时以该种模式破坏方块"),
    TWEAK_CHAT_BACKGROUND_COLOR     ("tweakChatBackgroundColor",            false, "",    "覆盖默认的聊天背景颜色\n在 通用设置 -> chatBackgroundColor 中设置"),
    TWEAK_CHAT_PERSISTENT_TEXT      ("tweakChatPersistentText",             false, "",    "存储已经输入的文本\n并在再次打开聊天时将其还原"),
    TWEAK_CHAT_TIMESTAMP            ("tweakChatTimestamp",                  false, "",    "为聊天消息添加时间戳"),
    TWEAK_COMMAND_BLOCK_EXTRA_FIELDS("tweakCommandBlockExtraFields",        false, "",    "向命令方块GUI添加额外的字段，以设置\n命令方块的名称，并查看统计信息结果"),
    TWEAK_CUSTOM_FLAT_PRESETS       ("tweakCustomFlatPresets",              false, "",    "向预设世界中添加自定义世界\n在 列表 -> flatWorldPresets 中修改"),
    TWEAK_ELYTRA_CAMERA             ("tweakElytraCamera",                   false, "",    "允许在按住elytraCamera热键的同时\n锁定真正的玩家旋转，然后控件将\n仅影响渲染/相机的单独的>相机旋转<"),
    TWEAK_SHULKERBOX_STACKING       ("tweakEmptyShulkerBoxesStack",         false, true, "",    "启用最多可堆叠64个空的潜影盒.\nNOTE:它们还将堆叠在库存中!在服务器上，这将导致\n不同步/故障，除非服务器安装有\n与之相同的mod"),
    TWEAK_SHULKERBOX_STACK_GROUND   ("tweakEmptyShulkerBoxesStackOnGround", false, true, "",    "空潜影盒最多堆叠至64\n当它作为物品掉在地上时"),
    TWEAK_EXPLOSION_REDUCED_PARTICLES ("tweakExplosionReducedParticles",    false, "",    "爆炸粒子效果屏蔽"),
    TWEAK_F3_CURSOR                 ("tweakF3Cursor",                       false, "",    "始终渲染开启F3后屏幕光标"),
    TWEAK_FAKE_SNEAKING             ("tweakFakeSneaking",                   false, "",    "启用 fake sneaking 后. 防止您从边缘跌落\n并不会降低移动速度"),
    TWEAK_FAST_BLOCK_PLACEMENT      ("tweakFastBlockPlacement",             false, "",    "开启本功能后，在新方块上移动光标时\n能快速/方便进行放置方块。同时有\n不同的模式避免不需要的方块放置。"),
    TWEAK_FAST_LEFT_CLICK           ("tweakFastLeftClick",                  false, "",    "在按住左键的同时自动快速左键单击。\n每个游戏刻的点击次数在Generic configs中设置."),
    TWEAK_FAST_RIGHT_CLICK          ("tweakFastRightClick",                 false, "",    "在按住右键的同时自动快速右键单击。\n每个游戏刻的点击次数在Generic configs中设置."),
    TWEAK_FILL_CLONE_LIMIT          ("tweakFillCloneLimit",                 false, true, "",    "允许在单人游戏中更改/fill和/clone命令的方块上限.\n新的上限可在Generic configs->fillCloneLimit设置"),
    TWEAK_FLY_SPEED                 ("tweakFlySpeed",                       false, "",    KeybindSettings.INGAME_BOTH, "在创造或旁观模式下启用本功能\n可以使用一些预设的飞行速度"),
    TWEAK_FLEXIBLE_BLOCK_PLACEMENT  ("tweakFlexibleBlockPlacement",         false, "",    "在按住本功能热键的同时，允许放置出来的方块不是正常放置方向\n例如漏斗和原木可以调整成不同朝向."),
    TWEAK_FREE_CAMERA               ("tweakFreeCamera",                     false, "",    "启用本功能后，你的灵魂会出窍变成旁观，而你的肉体仍留在原地"),
    TWEAK_FREE_CAMERA_MOTION        ("tweakFreeCameraMotion",               false, "",    "启用FreeCamera模式后，如果还启用了此功能，\n移动输入将影响灵魂而不是的肉体。\n提供此选项，以便在使用FreeCamera时也可以控制\n你的肉体\n在平时请禁用本选项，如果您只想在FreeCamera模式下控制灵魂\n只需为两个功能设置相同的热键"),
    TWEAK_GAMMA_OVERRIDE            ("tweakGammaOverride",                  false, "",    "用在 通用设置 中的伽马值覆盖现有伽马值\n相当于无限夜视"),
    TWEAK_HAND_RESTOCK              ("tweakHandRestock",                    false, "",    "当一组物品用完之后，会将下一组相同物品\n自动补充到你的手中"),
    TWEAK_HOLD_ATTACK               ("tweakHoldAttack",                     false, "",    "一直按住攻击键"),
    TWEAK_HOLD_USE                  ("tweakHoldUse",                        false, "",    "一直按住使用键"),
    TWEAK_HOTBAR_SCROLL             ("tweakHotbarScroll",                   false, "",    "通过鼠标滚轮启用快捷栏交换"),
    TWEAK_HOTBAR_SLOT_CYCLE         ("tweakHotbarSlotCycle",                false, "",    KeybindSettings.INGAME_BOTH, "[机翻]允许在每个放置的方块块之后循环选择的快捷栏栏插槽,\n直到设置的最大插槽编号。要快速调整该值,\n请在按住热键键的同时滚动滚轮"),
    TWEAK_HOTBAR_SLOT_RANDOMIZER    ("tweakHotbarSlotRandomizer",           false, "",    KeybindSettings.INGAME_BOTH, "[机翻]允许在每个放置的方块之后随机选定快捷栏栏插槽，最大设置为最大插槽编号。 要快速调整该值,\n请在按住热键键的同时滚动滚轮"),
    TWEAK_HOTBAR_SWAP               ("tweakHotbarSwap",                     false, "",    "[机翻]通过热键功能启用热键交换"),
    TWEAK_INVENTORY_PREVIEW         ("tweakInventoryPreview",               false, true, "",    "启用容器预览，同时将光标悬停在容器方块或容器实体上\n并按住其配置的热键键(默认为shift)"),
    TWEAK_ITEM_UNSTACKING_PROTECTION("tweakItemUnstackingProtection",       false, "",    "如果启用，则在使用时不允许在 列表-> unstackingItems 中配置的项目溢出\n例如，这是为了防止在收岩浆时将桶扔到熔岩中。”"),
    TWEAK_LAVA_VISIBILITY           ("tweakLavaVisibility",                 false, "",    "如果启用，并且玩家具有呼吸头盔和/或水下呼吸效果,\n则在熔岩下的失明效果会大大减少。"),
    TWEAK_MAP_PREVIEW               ("tweakMapPreview",                     false, "",    "按住shift按键并且将光标放置在地图上时，可以预览地图"),
    TWEAK_MOVEMENT_KEYS             ("tweakMovementKeysLast",               false, "",    "[机翻]如果启用，则相反的移动键不会互相抵消\n而是最后按下的键是活动输入"),
    TWEAK_PERIODIC_ATTACK           ("tweakPeriodicAttack",                 false, "",    "启用定期攻击（单击鼠标左键）\n在 通用设置 -> periodicAttackInterval 中配置"),
    TWEAK_PERIODIC_USE              ("tweakPeriodicUse",                    false, "",    "启用定期使用（单击鼠标右键）\n在 通用设置 -> periodicAttackInterval 中配置"),
    TWEAK_PERMANENT_SNEAK           ("tweakPermanentSneak",                 false, "",    "如果启用，玩家将一直潜行"),
    TWEAK_PERMANENT_SPRINT          ("tweakPermanentSprint",                false, "",    "如果启用，玩家将在向前移动时始终处于冲刺状态"),
    TWEAK_PLACEMENT_GRID            ("tweakPlacementGrid",                  false, "",    KeybindSettings.INGAME_BOTH, "[机翻]启用后，您只能以可配置的间隔将方块放置在网格模式中。\n要快速调整值，请在热键的同时滚动滚轮."),
    TWEAK_PLACEMENT_LIMIT           ("tweakPlacementLimit",                 false, "",    KeybindSettings.INGAME_BOTH, "[机翻]启用后，每次使用/右键单击只能放置一定数量的方块。\n要快速调整值，请在按住调整切换键绑定的同时滚动。"),
    TWEAK_PLACEMENT_RESTRICTION     ("tweakPlacementRestriction",           false, "",    "[机翻]启用展示位置限制模式\n  (Plane, Layer, Face, Column, Line, Diagonal)"),
    TWEAK_PLACEMENT_REST_FIRST      ("tweakPlacementRestrictionFirst",      false, "",    "限制方块放置，以便您只将方块放置在首次单击的相同类型方块上"),
    TWEAK_PLACEMENT_REST_HAND       ("tweakPlacementRestrictionHand",       false, "",    "限制方块放置，以便您只将手握的相同方块放置在相同类型方块上"),
    TWEAK_PLAYER_INVENTORY_PEEK     ("tweakPlayerInventoryPeek",            false, "",    "在按住配置的热键时，开启玩家背包的浏览/预览。"),
    TWEAK_POTION_WARNING            ("tweakPotionWarning",                  false, "",    "当非环境药水效果即将用尽时\n将警告消息显示在快捷快捷栏上方"),
    TWEAK_PRINT_DEATH_COORDINATES   ("tweakPrintDeathCoordinates",          false, "",    "在玩家死亡后，发送坐标至聊天栏。\n此功能最初来自nessie的有用的mod。"),
    TWEAK_PICK_BEFORE_PLACE         ("tweakPickBeforePlace",                false, "",    "[机翻]如果启用，则在每个方块放置之前，将切换到要放置的同一个方块"),
    TWEAK_PLAYER_LIST_ALWAYS_ON     ("tweakPlayerListAlwaysVisible",        false, "",    "如果启用，则在不按住热键键的情况下呈现玩家列表（默认情况下为TAB列表）"),
    TWEAK_REMOVE_OWN_POTION_EFFECTS ("tweakRemoveOwnPotionEffects",         false, "",    "在第一人称模式下从玩家身上移除药水效果粒子"),
    TWEAK_RENDER_INVISIBLE_ENTITIES ("tweakRenderInvisibleEntities",        false, "",    "启用后，将渲染不可见实体，就像它们处于旁观者模式一样."),
    TWEAK_RENDER_LIMIT_ENTITIES     ("tweakRenderLimitEntities",            false, "",    "允许限制每帧要渲染的某些特定类型的实体的数量。 \n目前不支持 经验球 和 物品 实体\n请参阅 通用配置 以了解限制。"),
    TWEAK_REPAIR_MODE               ("tweakRepairMode",                     false, "",    "将损坏的且具有经验修补的物品交换到玩家的手上\n允许在站在经验农场时自动修复它们"),
    TWEAK_SHULKERBOX_DISPLAY        ("tweakShulkerBoxDisplay",              false, "",    "按住shift并且将光标移动到物品上，可以预览潜影盒内物品(以及所有带有内容物的方块)"),
    TWEAK_SIGN_COPY                 ("tweakSignCopy",                       false, "",    "启用后，放置的告示牌将使用先前放置的告示牌中的文本。\n可以与tweakNoSignGui结合使用，以在制作第一个标记后\n启用该功能来快速放置告示牌的副本。"),
    TWEAK_SNAP_AIM                  ("tweakSnapAim",                        false, "",    KeybindSettings.INGAME_BOTH, "[机翻]启用了本功能，使玩家面对预先设定的精确偏航旋转"),
    TWEAK_SNAP_AIM_LOCK             ("tweakSnapAimLock",                    false, "",    "[机翻]启用对齐锁定，将偏航和/或俯仰旋转\n锁定为当前对齐值e"),
    TWEAK_SPECTATOR_TELEPORT        ("tweakSpectatorTeleport",              false, "",    "允许旁观模式玩家传送到其他旁观模式玩家。\n最初来自nessie有用的mod。"),
    TWEAK_STRUCTURE_BLOCK_LIMIT     ("tweakStructureBlockLimit",            false, true, "",    "允许重写结构方块限制。\n在 通用设置 -> structureBlockMaxSize 中修改上限"),
    TWEAK_SWAP_ALMOST_BROKEN_TOOLS  ("tweakSwapAlmostBrokenTools",          false, "",    "如果启用，则手中即将破损的任何可损坏物品都将换成新的"),
    TWEAK_TAB_COMPLETE_COORDINATE   ("tweakTabCompleteCoordinate",          false, "",    "如果启用此选项，则在准星不对准方块的情况下\n使用TAB补全坐标将使用玩家的位置\n而不是添加~字符."),
    TWEAK_TOOL_SWITCH               ("tweakToolSwitch",                     false, "",    "能够自动切换到针对目标方块的有效工具"),
    TWEAK_Y_MIRROR                  ("tweakYMirror",                        false, "",    "[机翻]将目标y位置镜像到块边界内。\n这基本上是用于将半砖或楼梯放置在与法线相反的顶部/底部状态"),
    TWEAK_ZOOM                      ("tweakZoom",                           false, "",    KeybindSettings.INGAME_BOTH, "启用使用缩放热键来放大画面（可能吧）");
	
    private final String name;
    private final String comment;
    private final String prettyName;
    private final IKeybind keybind;
    private final boolean defaultValueBoolean;
    private final boolean singlePlayer;
    private boolean valueBoolean;
    private IValueChangeCallback<IConfigBoolean> callback;

    private FeatureToggle(String name, boolean defaultValue, String defaultHotkey, String comment)
    {
        this(name, defaultValue, false, defaultHotkey, KeybindSettings.DEFAULT, comment);
    }

    private FeatureToggle(String name, boolean defaultValue, boolean singlePlayer, String defaultHotkey, String comment)
    {
        this(name, defaultValue, singlePlayer, defaultHotkey, KeybindSettings.DEFAULT, comment);
    }

    private FeatureToggle(String name, boolean defaultValue, String defaultHotkey, KeybindSettings settings, String comment)
    {
        this(name, defaultValue, false, defaultHotkey, settings, comment);
    }

    private FeatureToggle(String name, boolean defaultValue, boolean singlePlayer, String defaultHotkey, KeybindSettings settings, String comment)
    {
        this(name, defaultValue, singlePlayer, defaultHotkey, settings, comment, StringUtils.splitCamelCase(name.substring(5)));
    }

    private FeatureToggle(String name, boolean defaultValue, String defaultHotkey, String comment, String prettyName)
    {
        this(name, defaultValue, false, defaultHotkey, comment, prettyName);
    }

    private FeatureToggle(String name, boolean defaultValue, boolean singlePlayer, String defaultHotkey, String comment, String prettyName)
    {
        this(name, defaultValue, singlePlayer, defaultHotkey, KeybindSettings.DEFAULT, comment, prettyName);
    }

    private FeatureToggle(String name, boolean defaultValue, boolean singlePlayer, String defaultHotkey, KeybindSettings settings, String comment, String prettyName)
    {
        this.name = name;
        this.valueBoolean = defaultValue;
        this.defaultValueBoolean = defaultValue;
        this.singlePlayer = singlePlayer;
        this.comment = comment;
        this.prettyName = prettyName;
        this.keybind = KeybindMulti.fromStorageString(defaultHotkey, settings);
        this.keybind.setCallback(new KeyCallbackToggleBooleanConfigWithMessage(this));
    }

    @Override
    public ConfigType getType()
    {
        return ConfigType.HOTKEY;
    }

    @Override
    public String getName()
    {
        return this.name;
    }

    @Override
    public String getConfigGuiDisplayName()
    {
        if (this.singlePlayer)
        {
            return GuiBase.TXT_GOLD + this.getName() + GuiBase.TXT_RST;
        }

        return this.getName();
    }

    @Override
    public String getPrettyName()
    {
        return this.prettyName;
    }

    @Override
    public String getStringValue()
    {
        return String.valueOf(this.valueBoolean);
    }

    @Override
    public String getDefaultStringValue()
    {
        return String.valueOf(this.defaultValueBoolean);
    }

    @Override
    public void setValueFromString(String value)
    {
    }

    @Override
    public void onValueChanged()
    {
        if (this.callback != null)
        {
            this.callback.onValueChanged(this);
        }
    }

    @Override
    public void setValueChangeCallback(IValueChangeCallback<IConfigBoolean> callback)
    {
        this.callback = callback;
    }

    @Override
    public String getComment()
    {
        if (this.comment == null)
        {
            return "";
        }

        if (this.singlePlayer)
        {
            return this.comment + "\n" + StringUtils.translate("tweakeroo.label.config_comment.single_player_only");
        }
        else
        {
            return this.comment;
        }
    }

    @Override
    public IKeybind getKeybind()
    {
        return this.keybind;
    }

    @Override
    public boolean getBooleanValue()
    {
        return this.valueBoolean;
    }

    @Override
    public boolean getDefaultBooleanValue()
    {
        return this.defaultValueBoolean;
    }

    @Override
    public void setBooleanValue(boolean value)
    {
        boolean oldValue = this.valueBoolean;
        this.valueBoolean = value;

        if (oldValue != this.valueBoolean)
        {
            this.onValueChanged();
        }
    }

    @Override
    public boolean isModified()
    {
        return this.valueBoolean != this.defaultValueBoolean;
    }

    @Override
    public boolean isModified(String newValue)
    {
        return Boolean.parseBoolean(newValue) != this.defaultValueBoolean;
    }

    @Override
    public void resetToDefault()
    {
        this.valueBoolean = this.defaultValueBoolean;
    }

    @Override
    public JsonElement getAsJsonElement()
    {
        return new JsonPrimitive(this.valueBoolean);
    }

    @Override
    public void setValueFromJsonElement(JsonElement element)
    {
        try
        {
            if (element.isJsonPrimitive())
            {
                this.valueBoolean = element.getAsBoolean();
            }
            else
            {
                Tweakeroo.logger.warn("Failed to set config value for '{}' from the JSON element '{}'", this.getName(), element);
            }
        }
        catch (Exception e)
        {
            Tweakeroo.logger.warn("Failed to set config value for '{}' from the JSON element '{}'", this.getName(), element, e);
        }
    }
}
