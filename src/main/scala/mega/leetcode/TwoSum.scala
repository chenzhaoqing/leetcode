/**
  * Created by ChenZhaoqing on 2018/11/30.
  */
package mega.leetcode

object TwoSum {
  def twoSum(nums: Array[Int], target: Int): Array[Int] = {
    val map = scala.collection.mutable.HashMap.empty[Int, Int]
    for (i <- nums.indices) {
      val needed = target - nums(i)
      if (map.contains(needed)) {
        return Array(map(needed), i)
      } else {
        map += (nums(i) -> i)
      }
    }
    throw new IllegalArgumentException("No solution.")
  }
}