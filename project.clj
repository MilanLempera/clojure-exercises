(defproject clojure-exercises "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "MIT"}
  :dependencies [[org.clojure/clojure "1.9.0-alpha14"]
                 [org.clojure/core.async "0.2.395"]]
  :main ^:skip-aot clojure-exercises.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
