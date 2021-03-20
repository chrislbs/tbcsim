package `data`.items

import `data`.Constants
import `data`.buffs.Buffs
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
public class VengefulGladiatorsShanker : Item() {
  public override var isAutoGenerated: Boolean = true

  public override var id: Int = 33754

  public override var name: String = "Vengeful Gladiator's Shanker"

  public override var itemLevel: Int = 146

  public override var quality: Int = 4

  public override var icon: String = "inv_weapon_shortblade_62.jpg"

  public override var inventorySlot: Int = 13

  public override var itemSet: ItemSet? = null

  public override var itemClass: Constants.ItemClass? = Constants.ItemClass.WEAPON

  public override var itemSubclass: Constants.ItemSubclass? = Constants.ItemSubclass.DAGGER

  public override var allowableClasses: Array<Constants.AllowableClass>? = null

  public override var minDmg: Double = 148.0

  public override var maxDmg: Double = 223.0

  public override var speed: Double = 1800.0

  public override var stats: Stats = Stats(
      stamina = 30,
      physicalCritRating = 21.0,
      physicalHitRating = 8.0,
      resilienceRating = 12.0
      )

  public override var sockets: Array<Socket> = arrayOf()

  public override var socketBonus: SocketBonus? = null

  public override val buffs: List<Buff> by lazy {
        listOfNotNull(
        Buffs.byIdOrName(15806, "Attack Power 34", this),
        Buffs.byIdOrName(43901, "Armor Penetration 49", this)
        )}

}
