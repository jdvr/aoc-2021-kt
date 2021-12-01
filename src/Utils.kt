import java.io.File
import java.math.BigInteger
import java.security.MessageDigest

/**
 * Reads lines from the given input txt file.
 */
fun <T> readLinesAs(name: String, mapLine: (line: String) -> T): List<T> {
    return File("src", "$name.txt").readLines().map(mapLine)
}

/**
 * Converts string to md5 hash.
 */
fun String.md5(): String = BigInteger(1, MessageDigest.getInstance("MD5").digest(toByteArray())).toString(16)
