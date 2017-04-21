(ns clojure-exercises.the-joy-of-clojure.a-star-path.a-star-path
  (:require [clojure.pprint :as p]))

(def world [[1 1 1 1 1]
            [999 999 999 999 1]
            [1 1 1 1 1]
            [1 999 999 999 999]
            [1 1 1 1 1]])

(defn neighbours
  ([size xy] (neighbours [[-1 0] [1 0] [0 -1] [0 1]]
                         size
                         xy))
  ([deltas size xy] (filter (fn [new-xy]
                              (every? #(< -1 % size) new-xy))
                            (map #(vec (map + xy %))
                                 deltas))))

(defn estimate-cost [step-cost-est size x y]
  (* step-cost-est
     (- (+ size size) y x 2)))

(defn path-cost [node-cost cheapest-nbr]
  (+ node-cost
     (or (:cost cheapest-nbr) 0)))

(defn total-cost [new-cost step-cost-est size x y]
  (+ new-cost
     (estimate-cost step-cost-est size x y)))

(defn min-by [f coll]
  (when (seq coll)
    (reduce (fn [min other]
              (if (> (f min) (f other))
                other
                min))
            coll)))

(defn a-star [start-xy step-est cell-cost]
  (let [size (count cell-cost)]
    (loop [steps 0
           routes (vec (replicate size (vec (replicate size nil))))
           work-todo (sorted-set [0 start-xy])]
      (if (empty? work-todo)
        [(peek (peek routes)) :steps steps]
        (let [[_ xy :as work-item] (first work-todo)
              rest-work-todo (disj work-todo work-item)
              nbr-xys (neighbours size xy)
              cheapest-nbr (min-by :cost
                                   (keep #(get-in routes %)
                                         nbr-xys))
              new-cost (path-cost (get-in cell-cost xy)
                                  cheapest-nbr)
              old-cost (:cost (get-in routes xy))]
          (if (and old-cost (>= new-cost old-cost))
            (recur (inc steps) routes rest-work-todo)
            (recur (inc steps)
                   (assoc-in routes xy
                             {:cost new-cost
                              :xys  (conj (:xys cheapest-nbr [])
                                          xy)})
                   (into rest-work-todo
                         (map
                           (fn [[y x :as w]]
                             [(total-cost new-cost step-est size y x) w])
                           nbr-xys)))))))))

(a-star [0 0]
        900
        world)