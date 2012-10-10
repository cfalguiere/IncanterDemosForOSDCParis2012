(defproject perf-project "1.0.0-SNAPSHOT"
  :description "demos incanter in lein"
  :dependencies [[org.clojure/clojure "1.3.0"]
		 [incanter "1.3.0"]
		 [org.clojure/algo.generic "0.1.0"]
		 [clj-time "0.4.4"]]
  :dev-dependencies [[swank-clojure "1.4.2"][lein-midje "1.0.10"][com.stuartsierra/lazytest "1.2.3"]]
  :repositories {"stuart" "http://stuartsierra.com/maven2"}
  :main perf-project.core)
