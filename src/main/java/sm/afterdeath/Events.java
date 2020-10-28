package sm.afterdeath;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Events implements Listener {

    @EventHandler
    public void ClearAfterDeath(PlayerDeathEvent e){
        PlayerInventory playerInventory = e.getEntity().getInventory();

        //ItemStack itemTodelete = e.getEntity().getInventory().getContents()[rand];
        //e.getEntity().getInventory().removeItem(itemTodelete);



        List<ItemStack> itemList = Arrays.asList(e.getEntity().getInventory().getContents());
        int rand = new Random().nextInt(itemList.size()-1);
        int rand2 = new Random().nextInt(itemList.size()-1);
        int rand3 = new Random().nextInt(itemList.size()-1);
        int counter = 0;
        for (ItemStack item : e.getEntity().getInventory().getContents()) {
            counter++;
            if (item == null) {
                return;
            }
            else{
                if(counter == rand || counter == rand2 ||counter ==rand3){
                    e.getEntity().getInventory().removeItem(item);
                    e.getEntity().sendMessage("Utraciłeś "+item.getItemMeta().getDisplayName());
                }

            }
        }
    }


}
