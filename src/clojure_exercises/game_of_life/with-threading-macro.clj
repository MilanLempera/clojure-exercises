(ns clojure-exercises.game-of-life.base)

(defn neighbors-locations
  [[x y]]
  (for [dx [-1 0 1]
        dy [-1 0 1]
        :when (not= 0 dx dy)]
    [(+ x dx) (+ y dy)]))

(defn is-alive
  [location world]
  (contains? world location))

(defn rules-for-world
  [world]
  (fn
    [location count]
    (if (is-alive location world)
      (<= 2 count 3)
      (= count 3)
      )))

(defn next-step
  [world]
  (let [counts (frequencies (mapcat neighbors-locations world))
        rules (rules-for-world world)]

    (->>
      counts
      (filter #(apply rules %))
      (map first)
      (into #{}))))

;; --------------------------

(def initial-world
  #{[1 0]
    [0 0]
    [-1 0]})

(clojure.pprint/pprint
  (take 5 (iterate next-step initial-world)))