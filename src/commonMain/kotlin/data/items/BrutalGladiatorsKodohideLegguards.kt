package `data`.items

import `data`.Constants
import `data`.buffs.Buffs
import `data`.itemsets.ItemSets
import `data`.model.Item
import `data`.model.ItemSet
import `data`.model.Socket
import `data`.model.SocketBonus
import character.Buff
import character.Stats
import kotlin.Array
import kotlin.Boolean
import kotlin.Double
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import kotlin.js.JsExport

@JsExport
public class BrutalGladiatorsKodohideLegguards : Item() {
  public override var isAutoGenerated: Boolean = true

  public override var id: Int = 35024

  public override var name: String = "Brutal Gladiator's Kodohide Legguards"

  public override var itemLevel: Int = 159

  public override var quality: Int = 4

  public override var icon: String = "inv_pants_leather_07.jpg"

  public override var inventorySlot: Int = 7

  public override var itemSet: ItemSet? = ItemSets.byId(685)

  public override var itemClass: Constants.ItemClass? = Constants.ItemClass.ARMOR

  public override var itemSubclass: Constants.ItemSubclass? = Constants.ItemSubclass.LEATHER

  public override var allowableClasses: Array<Constants.AllowableClass>? = arrayOf(
      Constants.AllowableClass.DRUID
      )

  public override var minDmg: Double = 0.0

  public override var maxDmg: Double = 0.0

  public override var speed: Double = 0.0

  public override var stats: Stats = Stats(
      stamina = 65,
      intellect = 50,
      armor = 478,
      resilienceRating = 31.0
      )

  public override var sockets: Array<Socket> = arrayOf()

  public override var socketBonus: SocketBonus? = null

  public override val buffs: List<Buff> by lazy {
        listOfNotNull(
        Buffs.byIdOrName(39806, "Increase Healing 114", this),
        Buffs.byIdOrName(35836, "Increased Mana Regen", this)
        )}

}
