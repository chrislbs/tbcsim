package `data`.items

import `data`.Constants
import `data`.model.Color
import `data`.model.Item
import `data`.model.ItemSet
import `data`.model.Socket
import `data`.model.SocketBonus
import `data`.socketbonus.SocketBonuses
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
public class VindicatorsDragonhideBracers : Item() {
  public override var isAutoGenerated: Boolean = true

  public override var id: Int = 33881

  public override var name: String = "Vindicator's Dragonhide Bracers"

  public override var itemLevel: Int = 141

  public override var quality: Int = 4

  public override var icon: String = "inv_bracer_07.jpg"

  public override var inventorySlot: Int = 9

  public override var itemSet: ItemSet? = null

  public override var itemClass: Constants.ItemClass? = Constants.ItemClass.ARMOR

  public override var itemSubclass: Constants.ItemSubclass? = Constants.ItemSubclass.LEATHER

  public override var allowableClasses: Array<Constants.AllowableClass>? = arrayOf(
      Constants.AllowableClass.ROGUE,
      Constants.AllowableClass.DRUID
      )

  public override var minDmg: Double = 0.0

  public override var maxDmg: Double = 0.0

  public override var speed: Double = 0.0

  public override var stats: Stats = Stats(
      strength = 22,
      agility = 22,
      stamina = 29,
      armor = 236,
      physicalCritRating = 21.0,
      resilienceRating = 17.0
      )

  public override var sockets: Array<Socket> = arrayOf(
      Socket(Color.RED)
      )

  public override var socketBonus: SocketBonus? = SocketBonuses.byId(2867)

  public override val buffs: List<Buff> by lazy {
        listOf()}

}
