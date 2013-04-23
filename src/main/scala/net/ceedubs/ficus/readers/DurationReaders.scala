package net.ceedubs.ficus.readers

import scala.concurrent.duration.FiniteDuration
import com.typesafe.config.Config
import scala.concurrent.duration.MILLISECONDS

trait DurationReaders {

  /**
   * A reader for for a scala.concurrent.duration.FiniteDuration. This reader should be able to read any valid duration
   * format as defined by the <a href="https://github.com/typesafehub/config/blob/master/HOCON.md">HOCON spec</a>.
   * For example, it can read "15 minutes" or "1 day".
   */
  implicit def finiteDurationReader: ValueReader[FiniteDuration] = new ValueReader[FiniteDuration] {
    def get(config: Config, path: String): FiniteDuration = {
      val millis = config.getMilliseconds(path)
      FiniteDuration(millis, MILLISECONDS)
    }
  }
}

object DurationReaders extends DurationReaders
