package sm.afterdeath;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Events implements Listener {

    @EventHandler
    public void ClearAfterDeath(PlayerRespawnEvent e){
        List<ItemStack> items = Arrays.stream(e.getPlayer().getInventory().getContents())
        .collect(Collectors.toList());
        int rand = new Random().nextInt(items.size()-1);
        ItemStack itemToRemove = e.getPlayer().getInventory().getContents()[rand];
        e.getPlayer().getInventory().remove(itemToRemove);
        Bukkit.broadcastMessage("Gracz "+e.getPlayer().getName()+" utracił "+itemToRemove.toString()+", F");

    }


}
