package `data`.items

import `data`.Constants
import `data`.buffs.Buffs
import `data`.model.Item
import `data`.model.ItemSet
import `data`.model.Socket
import `data`.model.SocketBonus
import character.Buff
import character.Stats
import kotlin.Boolean
import kotlin.Double
import kotlin.Int
import kotlin.String
import kotlin.collections.List

public class TimeShiftedDagger : Item() {
  public override var isAutoGenerated: Boolean = true

  public override var name: String = "Time-Shifted Dagger"

  public override var itemLevel: Int = 103

  public override var itemSet: ItemSet? = null

  public override var itemClass: Constants.ItemClass? = Constants.ItemClass.WEAPON

  public override var itemSubclass: Constants.ItemSubclass? = Constants.ItemSubclass.DAGGER

  public override var minDmg: Double = 37.790000915527344

  public override var maxDmg: Double = 102.79000091552734

  public override var speed: Double = 1700.0

  public override var stats: Stats = Stats(
      stamina = 15,
      intellect = 15,
      spellCritRating = 13.0
      )

  public override var sockets: List<Socket> = listOf()

  public override var socketBonus: SocketBonus? = null

  public override var buffs: List<Buff> = listOfNotNull(
      Buffs.byId(28687)
      )
}