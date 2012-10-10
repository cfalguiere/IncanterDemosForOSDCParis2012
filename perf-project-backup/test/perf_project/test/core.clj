(ns perf-project.test.core
  (:use [perf-project.core])
  (:use [clojure.test])
  (:require [incanter.core :as incanter]))

;;  (is [:count 1 :mean 2 :sd 0 :min 2 :q95 2 :max 2 ]

  
(deftest perf-summary-test
  (let [ ds (incanter/dataset [:t] [{:t 5}{:t 5}] )
	result (perf-summary ds)]
    (println ds)
    (println result)
    (is (not (= nil result)))
    (is (= true (map? result)))
    (is (= 2 (:count result)))
    (is (= 5.0 (:mean result)))
    (is (= 0.0 (:sd result)))
    (is (= 5.0 (:min result)))
    (is (= 5.0 (:q95 result)))
    (is (= 5.0 (:max result)))
    ))
