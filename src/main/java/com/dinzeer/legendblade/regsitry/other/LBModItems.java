
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package com.dinzeer.legendblade.regsitry.other;


import com.dinzeer.legendblade.regsitry.creativetab.ItemTab;
import com.exfantasy.mclib.Utils.local.ItemtipUtil;
import com.tterrag.registrate.util.entry.ItemEntry;
import com.dinzeer.legendblade.item.*;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;


import static com.dinzeer.legendblade.Legendblade.MODID;
import static com.dinzeer.legendblade.Legendblade.REGISTRATE;

public class LBModItems {
//	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);

	public static final ItemEntry<Item> slightlyred_tachi;
	public static final ItemEntry<Item> iron_tachi;
	public static final ItemEntry<Item> lightred_tachi;
	public static final ItemEntry<Item> red_tachi;
	public static final ItemEntry<Item> sored_tachi;
	public static final ItemEntry<Item> blood_tachi;
	public static final ItemEntry<Item> crimsonjadeofuda;
	public static final ItemEntry<Item> jadeofuda;
	public static final ItemEntry<Item> lightpinkjadeofuda;
	public static final ItemEntry<Item> pinkjadeofuda;
	public static final ItemEntry<Item> redjadeofuda;
	public static final ItemEntry<Item> scarletjadeofuda;
	public static final ItemEntry<Item> tearfluorite;
	public static final ItemEntry<TooltipItem> acedia;
	public static final ItemEntry<TooltipItem> avaritia;
	public static final ItemEntry<TooltipItem> gula;
	public static final ItemEntry<TooltipItem> invidia;
	public static final ItemEntry<TooltipItem> ira;
	public static final ItemEntry<TooltipItem> luxuria;
	public static final  ItemEntry<Item> saligiaex;
	public static final  ItemEntry<Item> saligiasphere;
	public static final ItemEntry<TooltipItem> superbia;
	public static final  ItemEntry<Item> icegem;
	public static final  ItemEntry<TooltipItem> soul_crystal;
	public static final  ItemEntry<Item> water_gem;
	public static final  ItemEntry<Item> dragon_gem;


	static {

		slightlyred_tachi = iteminit("slightlyred_tachi");
		iron_tachi = iteminit("iron_tachi");
		lightred_tachi= iteminit("lightred_tachi");
		red_tachi = iteminit("red_tachi");
		sored_tachi = iteminit("sored_tachi");
		blood_tachi = iteminit("blood_tachi");
		crimsonjadeofuda = iteminit("crimsonjadeofuda");
		jadeofuda=iteminit("jadeofuda");
		lightpinkjadeofuda=iteminit("lightpinkjadeofuda");
		pinkjadeofuda=iteminit("pinkjadeofuda");
		redjadeofuda=iteminit("redjadeofuda");
		scarletjadeofuda=iteminit("scarletjadeofuda");
		tearfluorite=iteminit("tearfluorite");

		acedia= iteminit("acedia","Use evil Kill Silverfish to obtain");
		avaritia= iteminit("avaritia","Use evil Kill piglin to obtain");
		gula= iteminit("gula","Use evil Kill zombie to obtain");
		invidia= iteminit("invidia","Use evil Kill wither to obtain");
		ira= iteminit("ira","Use evil Kill blazeman to obtain");
		luxuria= iteminit("luxuria","Use evil Kill witch to obtain");
		superbia= iteminit("superbia","Use evil Kill enderman to obtain");
		saligiaex= iteminit("saligiaex");
		saligiasphere= iteminit("saligiasphere");

        icegem= iteminit("ice_gem");
		soul_crystal= iteminit("soul_crystal","Align the knife on the knife hanging table and use it to increase three values for the knife");
		water_gem=iteminit("water_gem");
		dragon_gem=iteminit("dragon_gem");
}
















	public static ItemEntry<Item> iteminit(String name){
            return REGISTRATE.item(
                    name, Item::new
            ).defaultModel().defaultLang().tab(ItemTab.LBITEM.getKey()).register();


    }
	public static ItemEntry<TooltipItem> iteminit(String name,String lang){

		Component tooltip=ItemtipUtil.Tooltiplocal(MODID,name);
		REGISTRATE.addRawLang(tooltip.getString(),lang);
		return REGISTRATE.item(
				name,properties -> new TooltipItem(properties,tooltip)
		).defaultModel().defaultLang().tab(ItemTab.LBITEM.getKey()).register();


	}



	public static void register() {
	}






}
