object CaesarCipher {

  private val alphabetSize = 26

  private def shiftChar(char: Char, shift: Int): Char = {
    if (char.isLetter) {
      val base = if (char.isLower) 'a' else 'A'
      ((char - base + shift) % alphabetSize + base).toChar
    } else {
      char
    }
  }

  def encrypt(plaintext: String, shift: Int): String = {
    plaintext.map(char => shiftChar(char, shift))
  }

  def decrypt(ciphertext: String, shift: Int): String = {
    encrypt(ciphertext, alphabetSize - shift)
  }

  def cipher(data: String, shift: Int, operation: (String,Int) => String): String = {
    operation(data,shift)
  }

  def main(args: Array[String]): Unit = {
    val plaintext = "Hello, World!"
    val shift = 3

    // Encryption
    val encryptedText = cipher(plaintext, shift, encrypt)
    println(s"Encrypted: $encryptedText")

    // Decryption
    val decryptedText = cipher(encryptedText, shift, decrypt)
    println(s"Decrypted: $decryptedText")
  }
}
