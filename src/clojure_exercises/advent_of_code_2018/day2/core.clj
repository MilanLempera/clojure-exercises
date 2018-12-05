(ns clojure-exercises.advent-of-code-2018.day2.core
  (:require [clojure.string :as str]
            [clojure.data :as data]))

(def letters->counts (juxt #(% 2) #(% 3)))

(defn text->counts [text]
  (->> text
       seq
       frequencies
       vals
       (into #{})
       letters->counts))

(defn calculate-number-by-letters-count [texts]
  (->> texts
       (map text->counts)
       (reduce (fn [acc [two three]]
                 (cond-> acc
                         (some? two) (update 0 inc)
                         (some? three) (update 1 inc)
                         ))
               [0 0])
       (apply *)))

(defn get-diff [box1 box2]
  (last (data/diff
          (seq box1)
          (seq box2))))

(defn get-same-letters [texts]
  (for [box1 texts
        box2 texts
        :let [diff (get-diff box1 box2)
              diff-count (count (filter some? diff))]
        :when (= (count box1)
                 (inc diff-count))]
    (->> diff
         (filter some?)
         str/join)))

;------------------------------------

(def input (-> "/Users/milanlempera/projects/training/clojure/clojure-exercises/src/clojure_exercises/advent_of_code_2018/day2/input.txt"
               slurp
               str/split-lines))

(calculate-number-by-letters-count input)


(first (get-same-letters input))

