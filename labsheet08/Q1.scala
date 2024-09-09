object SimpleCaesarCipher {

  def encrypt(text: String, shift: Int): String = {
    text.map { char =>
      if (char.isLetter) {
        val asciiOffset = if (char.isUpper) 'A' else 'a'
        ((char - asciiOffset + shift) % 26 + asciiOffset).toChar
      } else {
        char
      }
    }
  }

  def decrypt(text: String, shift: Int): String = {
    encrypt(text, -shift)
  }

  def caesarCipher(text: String, shift: Int, mode: String): String = {
    mode.toLowerCase match {
      case "encrypt" => encrypt(text, shift)
      case "decrypt" => decrypt(text, shift)
      case _ => throw new IllegalArgumentException("Mode must be 'encrypt' or 'decrypt'")
    }
  }

  def main(args: Array[String]): Unit = {
    val plaintext = "Hello, World!"
    val shift = 4

    val encryptedText = caesarCipher(plaintext, shift, "encrypt")
    println(s"Encrypted: $encryptedText")

    val decryptedText = caesarCipher(encryptedText, shift, "decrypt")
    println(s"Decrypted: $decryptedText")
  }
}
