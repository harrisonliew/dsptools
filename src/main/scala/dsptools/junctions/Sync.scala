// See LICENSE for license details.

package dsptools.junctions

import chisel3._

trait WithSync {
  val sync = Output(Bool())
}

class ValidWithSync[+T <: Data](gen: T) extends Valid[T](gen) with WithSync {
  override def cloneType: this.type = ValidWithSync(gen).asInstanceOf[this.type]
}

object ValidWithSync {
  def apply[T <: Data](gen: T) = new ValidWithSync(gen)
}

class DecoupledWithSync[+T <: Data](gen: T) extends Decoupled[T](gen) with WithSync {
  override def cloneType: this.type = DecoupledWithSync(gen).asInstanceOf[this.type]
}

object DecoupledWithSync {
  def apply[T <: Data](gen: T) = new DecoupledWithSync(gen)
}