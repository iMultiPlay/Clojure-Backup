(defproject matrix-play "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [net.mikera/core.matrix "0.29.1"]
                 [clatrix "0.3.0"]]
  :main ^:skip-aot matrix-play.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
