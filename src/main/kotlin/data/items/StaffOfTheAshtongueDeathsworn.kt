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

public class StaffOfTheAshtongueDeathsworn : Item() {
  public override var isAutoGenerated: Boolean = true

  public override var name: String = "Staff of the Ashtongue Deathsworn"

  public override var itemLevel: Int = 109

  public override var itemSet: ItemSet? = null

  public override var itemClass: Constants.ItemClass? = Constants.ItemClass.WEAPON

  public override var itemSubclass: Constants.ItemSubclass? = Constants.ItemSubclass.STAFF

  public override var minDmg: Double = 162.5399932861328

  public override var maxDmg: Double = 292.5400085449219

  public override var speed: Double = 3700.0

  public override var stats: Stats = Stats(
      stamina = 27,
      intellect = 45,
      spirit = 25
      )

  public override var sockets: List<Socket> = listOf()

  public override var socketBonus: SocketBonus? = null

  public override var buffs: List<Buff> = listOfNotNull(
      Buffs.byId(36428)
      )
}