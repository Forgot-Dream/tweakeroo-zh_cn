package fi.dy.masa.tweakeroo;

import java.io.File;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.mumfrey.liteloader.Configurable;
import com.mumfrey.liteloader.LiteMod;
import com.mumfrey.liteloader.Tickable;
import com.mumfrey.liteloader.modconfig.ConfigPanel;
import fi.dy.masa.tweakeroo.config.Configs;
import fi.dy.masa.tweakeroo.config.gui.TweakerooConfigPanel;
import fi.dy.masa.tweakeroo.util.Tweaks;
import net.minecraft.client.Minecraft;

public class LiteModTweakeroo implements LiteMod, Configurable, Tickable
{
    public static final Logger logger = LogManager.getLogger(Reference.MOD_ID);

    public LiteModTweakeroo()
    {
    }

    @Override
    public String getName()
    {
        return Reference.MOD_NAME;
    }

    @Override
    public String getVersion()
    {
        return Reference.MOD_VERSION;
    }

    @Override
    public Class<? extends ConfigPanel> getConfigPanelClass()
    {
        return TweakerooConfigPanel.class;
    }

    @Override
    public void init(File configPath)
    {
        Configs.load();
    }

    @Override
    public void upgradeSettings(String version, File configPath, File oldConfigPath)
    {
    }

    @Override
    public void onTick(Minecraft minecraft, float partialTicks, boolean inGame, boolean clock)
    {
        if (minecraft.currentScreen == null && minecraft.gameSettings.keyBindUseItem.isKeyDown())
        {
            Tweaks.onUsingTick();
        }
        else
        {
            Tweaks.clearClickedBlockInfo();
        }
    }
}