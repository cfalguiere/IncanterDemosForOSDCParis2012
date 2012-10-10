;;; load before demo - it takes a while
(use '(incanter core io))

(def ds (read-dataset  "readings.csv" :header true) )

;;; how many lines ?
(nrow ds)

;;; view data
(view ds)

(def dsh ($where {:lb "SU01-HomePage-Page"} ds)) 

;;; show only time
(view ($ :t dsh))

;;; compute stats
(count dsh)
(mean ($ :t dsh))
(sd ($ :t dsh))

;;; view time-series
(view (time-series-plot :ts :t :data dsh))

;; mean per group
($rollup mean :t :lb ds) ; yield a dataset
(def means ($rollup mean :t :lb ds)) ; yield a dataset

;;; bar-chart count per labels
(view (bar-chart :lb :t :vertical false :data  means))
