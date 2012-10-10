;;; lein repl
(use '(incanter core io))
(def ds (read-dataset "../readings.csv" :header true))
(nrow ds)

(use '(perf-project core))

(perf-summary ds)
;;{:max 16696.0, :q95 2196.0, :min 17.0, :sd 998.3607924056075, :mean 982.5533694048205, :count 4066}

(view (perf-time-series-plot ds 3000))
(view (perf-histogram ds))

(view (count-bar-chart ds :lb))
(view (mean-time-bar-chart ds :lb))
