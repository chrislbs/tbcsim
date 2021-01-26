package `data`.items

import `data`.Constants
import `data`.buffs.Buffs
import `data`.model.Color
import `data`.model.Item
import `data`.model.ItemSet
import `data`.model.Socket
import `data`.model.SocketBonus
import `data`.socketbonus.SocketBonuses
import character.Buff
import character.Stats
import kotlin.Boolean
import kotlin.Double
import kotlin.Int
import kotlin.String
import kotlin.collections.List

public class BlackoutTruncheon : Item() {
  public override var isAutoGenerated: Boolean = true

  public override var name: String = "Blackout Truncheon"

  public override var itemLevel: Int = 112

  public override var itemSet: ItemSet? = null

  public override var itemClass: Constants.ItemClass? = Constants.ItemClass.WEAPON

  public override var itemSubclass: Constants.ItemSubclass? = Constants.ItemSubclass.MACE_1H

  public override var minDmg: Double = 73.0

  public override var maxDmg: Double = 136.0

  public override var speed: Double = 1500.0

  public override var stats: Stats = Stats(

      )

  public override var sockets: List<Socket> = listOf(
      Socket(Color.RED),
      Socket(Color.YELLOW)
      )

  public override var socketBonus: SocketBonus? = SocketBonuses.byId(1584)

  public override var buffs: List<Buff> = listOfNotNull(
      Buffs.byId(33489)
      )
}