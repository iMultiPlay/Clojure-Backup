(defproject squid-neural-networks "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [net.mikera/core.matrix "0.29.1"]]
  :main ^:skip-aot squid-neural-networks.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
