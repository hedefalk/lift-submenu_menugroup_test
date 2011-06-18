package bootstrap.liftweb

import _root_.net.liftweb.common._
import _root_.net.liftweb.util._
import _root_.net.liftweb.http._
import _root_.net.liftweb.sitemap._
import _root_.net.liftweb.sitemap.Loc._
import Helpers._

/**
 * A class that's instantiated early and run.  It allows the application
 * to modify lift's environment
 */
class Boot {
  def boot {
    // where to search snippet
    LiftRules.addToPackages("net.liftweb.submenu_menugroup_test")

    // Build SiteMap
    def entries = List(
      Menu("index") / "index" >> LocGroup("mygroup"),
      Menu(S ? "1") / "1" >> LocGroup("mygroup") submenus
        (Menu(S ? "1_1") / "1_1" >> LocGroup("mygroup"),
          Menu(S ? "1_2") / "1_2" >> LocGroup("mygroup")),
      Menu(S ? "2") / "2" >> LocGroup("mygroup") submenus
        (Menu(S ? "2_1") / "2_1",
          Menu(S ? "2_2") / "2_2"),
      Menu("3") / "3" >> LocGroup("notshown"))

      
    if (Props.devMode) {
      LiftRules.setSiteMapFunc(() => SiteMap(entries: _*))
    } else {
      LiftRules.setSiteMap(SiteMap(entries: _*))
    }

    LiftRules.setSiteMap(SiteMap(entries: _*))
  }
}

