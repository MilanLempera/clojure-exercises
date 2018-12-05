(ns clojure-exercises.advent-of-code-2018.day3.core
  (:require [clojure.string :as str]
            [clojure.set :as set]))

(defn parse-row [text-row]
  (->> text-row
       (re-matches #"#(\d+).* (\d+),(\d+): (\d+)x(\d+)")
       (drop 1)
       (map read-string)))

(defn coordinate->points [[x-start y-start w h]]
  (for [x (range x-start (+ x-start w))
        y (range y-start (+ y-start h))]
    [x y]))

(defn find-conflicts [points-by-id]
  (->> points-by-id
       vals
       (apply concat)
       frequencies
       (filter #(> (second %) 1))
       keys
       (into #{})))

(defn lines->points [input]
  (->> input
       (map parse-row)
       (mapcat (fn [coordinate] [(first coordinate) (coordinate->points (rest coordinate))]))
       (apply array-map)))

(defn find-non-conflict-points [points-by-id conflict-points]
  (->> points-by-id
       (filter #(empty? (set/intersection conflict-points (into #{} (second %)))))
       (map first)))

;---------------
(def input
  (-> "/Users/milanlempera/projects/training/clojure/clojure-exercises/src/clojure_exercises/advent_of_code_2018/day3/input.txt"
      slurp
      str/split-lines))

(let [points-by-id (lines->points input)
      conflict-points (find-conflicts points-by-id)]

  {:count               (count conflict-points)
   :non-conflict-points (find-non-conflict-points points-by-id conflict-points)})
