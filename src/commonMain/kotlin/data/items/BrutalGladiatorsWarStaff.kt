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
public class BrutalGladiatorsWarStaff : Item() {
  public override var isAutoGenerated: Boolean = true

  public override var id: Int = 35109

  public override var name: String = "Brutal Gladiator's War Staff"

  public override var itemLevel: Int = 154

  public override var quality: Int = 4

  public override var icon: String = "inv_staff_74.jpg"

  public override var inventorySlot: Int = 17

  public override var itemSet: ItemSet? = null

  public override var itemClass: Constants.ItemClass? = Constants.ItemClass.WEAPON

  public override var itemSubclass: Constants.ItemSubclass? = Constants.ItemSubclass.STAFF

  public override var allowableClasses: Array<Constants.AllowableClass>? = null

  public override var minDmg: Double = 86.4000015258789

  public override var maxDmg: Double = 199.39999389648438

  public override var speed: Double = 2000.0

  public override var stats: Stats = Stats(
      stamina = 66,
      intellect = 50,
      spellCritRating = 50.0,
      resilienceRating = 29.0
      )

  public override var sockets: Array<Socket> = arrayOf()

  public override var socketBonus: SocketBonus? = null

  public override val buffs: List<Buff> by lazy {
        listOfNotNull(
        Buffs.byIdOrName(44751, "Increase Spell Dam 266", this),
        Buffs.byIdOrName(46060, "Increased Spell Penetration 40", this)
        )}

}
