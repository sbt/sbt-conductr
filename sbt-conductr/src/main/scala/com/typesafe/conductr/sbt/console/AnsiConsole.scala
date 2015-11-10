/*
 * Copyright © 2014 Typesafe, Inc. All rights reserved.
 */

package com.typesafe.conductr.sbt
package console

import org.fusesource.jansi.Ansi

/**
 * A wrapper of ASNI terminal functions.
 */
object AnsiConsole {

  /**
   * Clear terminal screen and move the cursor to the upper-left corner.
   */
  def clear(): Unit =
    print(Ansi.ansi().eraseScreen().cursor(0, 0))

  /**
   * No real support for hiding cursor. Currently moving the cursor to the
   * bottom-right corner.
   */
  def hideCursor(): Unit =
    print(Ansi.ansi().cursor(1000, 1000))

  /**
   * Go to specified line.
   */
  def goToLine(line: Int) =
    print(Ansi.ansi().cursor(line, 0))

  object Implicits {

    implicit class AnsiString(s: String) {
      private val textColorInv = "white"
      private val backColorInv = "bg_black"

      /**
       * Invert text and background.
       */
      def invert: String =
        s"@|$textColorInv,$backColorInv $s|@"

      /**
       * Convert from JANSI pseudo language to terminal control codes.
       */
      def render: String =
        Ansi.ansi().render(s).toString

      /**
       * Length of the string as seen in the terminal.
       */
      def visibleLength: Int =
        s.replaceAll("""@\|[a-z_,]+ ([^\|]+)\|@""", "$1").length

      def asInfo: String =
        s"[info] $s"

      def asWarn: String =
        s"[${scala.Console.YELLOW}warn${scala.Console.RESET}] $s"

      def asError: String =
        s"[${scala.Console.RED}error${scala.Console.RESET}] $s"
    }

  }
}
