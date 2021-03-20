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
public class GladiatorsWarStaff : Item() {
  public override var isAutoGenerated: Boolean = true

  public override var id: Int = 24557

  public override var name: String = "Gladiator's War Staff"

  public override var itemLevel: Int = 123

  public override var quality: Int = 4

  public override var icon: String = "inv_staff_53.jpg"

  public override var inventorySlot: Int = 17

  public override var itemSet: ItemSet? = null

  public override var itemClass: Constants.ItemClass? = Constants.ItemClass.WEAPON

  public override var itemSubclass: Constants.ItemSubclass? = Constants.ItemSubclass.STAFF

  public override var allowableClasses: Array<Constants.AllowableClass>? = null

  public override var minDmg: Double = 89.4000015258789

  public override var maxDmg: Double = 185.39999389648438

  public override var speed: Double = 2000.0

  public override var stats: Stats = Stats(
      stamina = 48,
      intellect = 35,
      spellCritRating = 36.0,
      spellHitRating = 21.0,
      resilienceRating = 25.0
      )

  public override var sockets: Array<Socket> = arrayOf()

  public override var socketBonus: SocketBonus? = null

  public override val buffs: List<Buff> by lazy {
        listOfNotNull(
        Buffs.byIdOrName(41973, "Increase Spell Dam 199", this)
        )}

}
