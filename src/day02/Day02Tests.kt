package day02

import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.jupiter.api.Test;

class Day02Tests {
    private val testInput = arrayOf(
        Forward(5),
        Down(5),
        Forward(8),
        Up(3),
        Down(8),
        Forward(2),
    )

    @Test
    fun `map a line`() {
        assertThat(mapLine("forward 4")).isEqualTo(Forward(4))
        assertThat(mapLine("down 6")).isEqualTo(Down(6))
        assertThat(mapLine("up 9")).isEqualTo(Up(9))
    }

    @Test
    fun `part 1 for test input returns 150`() {
        val (horizontal, depth) = calculatePosition(
            testInput
        )

        assertThat(horizontal * depth).isEqualTo(150)
    }

    @Test
    fun `part 2 for test input returns 150`() {
        val (horizontal, depth, aim) = calculatePositionWithAim(
            testInput
        )

        assertThat(horizontal * depth).isEqualTo(900)
    }
}
