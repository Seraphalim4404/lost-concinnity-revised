package FORGOTTEN;

import FORGOTTEN.content.LOSTStatusEffects;
import arc.*;
import arc.util.*;
import mindustry.game.EventType.*;
import mindustry.mod.*;
import mindustry.ui.dialogs.*;

public class Unloader extends Mod{

    public Unloader(){
        
        Log.info("How to mod in Java.mp4");
        Events.on(ClientLoadEvent.class, e -> {

            Time.runTask(10f, () -> {
                BaseDialog dialog = new BaseDialog("frog");
                dialog.cont.add("behold").row();
                //mod sprites are prefixed with the mod name (this mod is called 'example-java-mod' in its config)
                dialog.cont.image(Core.atlas.find("example-java-mod-frog")).pad(20f).row();
                dialog.cont.button("I see", dialog::hide).size(100f, 50f);
                dialog.show();
            });
        });
    }

    @Override
    public void loadContent(){
        LOSTStatusEffects.load();
        Log.info("Loading some example content.");
    }

}
