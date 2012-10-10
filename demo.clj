(use '(incanter core io))

(def ds (read-dataset  "readings.csv" :header true) )

;;; how many lines ?
(nrow ds)

;;; view data
(view ds)

;;; view data sorted by time
(view ($order :t :desc ds))

;;; show only shop; label, time
(view ($ [:shop :lb :t] ds ))

;;; show only time
(view ($ :t ds ))

;;; show time series
(view (time-series-plot :ts :t :data ds))

;;; compute stats
(mean ($ :t ds))
(sd ($ :t ds))
(quantile ($ :t ds) :probs [0.90])

(with-data ($ :t ds)
  [ (count $data) (mean $data) (sd $data) (quantile $data :probs[0.95]) ] ) 

;; mapping
($map #(> % 3000) [:t] ds)
($map #(cond (> % 3000) (- % 3000) :else 0) [:t] ds)

;;; filtering big numbers
(view ($where {:t {:$gt 5000} } dsok))

;;; filtering valid readings 
(def dsok  ($where {:s "true" :rc 200} ds))
(view (time-series-plot :ts :t :data dsok))


;;; filtering labels
(distinct ($ :lb dsok))

(def dsokhome ($where {:lb "SU01-HomePage-Page"} dsok)) 
(view (time-series-plot :ts :t :data dsokhome))

;;; group by labels
(keys ($group-by :lb ds))

(def dsokhome2 (get ($group-by :lb dsok) {:lb "SU01-HomePage-Page"} ))
(nrow dsokhome2)

;; mean per group
($rollup mean :t :lb dsok) ; yield a dataset

;;; bar-chart count per labels
(view (bar-chart :lb :t :vertical false
		 :data  ($rollup count :t :lb dsok)))
