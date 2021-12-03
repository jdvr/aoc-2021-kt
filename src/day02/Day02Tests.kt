package day02

import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.jupiter.api.Test;

class Day02Tests {
    @Test
    fun `part 1 for test input returns 150`() {
        val (horizontal, depth) = calculatePosition(arrayOf(
            Command("forward", 5),
            Command("down", 5),
            Command("forward", 8),
            Command("up", 3),
            Command("down", 8),
            Command("forward", 2),
        ))

        assertThat(horizontal * depth).isEqualTo(150)
    }

    @Test
    fun `part 2 for test input returns 150`() {
        val (horizontal, depth, aim) = calculatePositionWithAim(arrayOf(
            Command("forward", 5),
            Command("down", 5),
            Command("forward", 8),
            Command("up", 3),
            Command("down", 8),
            Command("forward", 2),
        ))

        assertThat(horizontal * depth).isEqualTo(900)
    }
}
