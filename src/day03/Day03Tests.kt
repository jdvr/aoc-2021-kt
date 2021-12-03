package day03

import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.jupiter.api.Test;

class Day03Tests {
    private val testInput = arrayOf(
        arrayOf(0, 0, 1, 0, 0),
        arrayOf(1, 1, 1, 1, 0),
        arrayOf(1, 0, 1, 1, 0),
        arrayOf(1, 0, 1, 1, 1),
        arrayOf(1, 0, 1, 0, 1),
        arrayOf(0, 1, 1, 1, 1),
        arrayOf(0, 0, 1, 1, 1),
        arrayOf(1, 1, 1, 0, 0),
        arrayOf(1, 0, 0, 0, 0),
        arrayOf(1, 1, 0, 0, 1),
        arrayOf(0, 0, 0, 1, 0),
        arrayOf(0, 1, 0, 1, 0)
    )

    @Test
    fun `map a line`() {
        assertThat(mapLine("01010")).isEqualTo(arrayOf(0, 1, 0, 1, 0))
        assertThat(mapLine("00100")).isEqualTo(arrayOf(0, 0, 1, 0, 0))
        assertThat(mapLine("0010011")).isEqualTo(arrayOf(0, 0, 1, 0, 0, 1, 1))
    }

    @Test
    fun `part 1 gamma rate for test input returns 10110`() {
        assertThat(
            gammaRate(
                testInput
            )
        ).isEqualTo("10110")
        assertThat(
            gammaRate(
                arrayOf(
                    arrayOf(1,0),
                    arrayOf(1,1),
                    arrayOf(1,0)
                )
            )
        ).isEqualTo("10")
    }

    @Test
    fun `part 1 epsilon rate for test input returns 01001`() {
        assertThat(
            epsilonRate(
                testInput
            )
        ).isEqualTo("01001")
    }

    @Test
    fun `bin to decimal`() {
        assertThat(binToDecimal("10110")).isEqualTo(22)
        assertThat(binToDecimal("01001")).isEqualTo(9)
    }

    @Test
    fun `part 2 for test input returns 150`() {

    }
}
