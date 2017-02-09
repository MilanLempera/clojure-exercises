(ns clojure-exercises.spec.generator
  (:require [clojure.spec :as s]
            [clojure.spec.gen :as gen]))

(s/def ::point (s/tuple double? string?))

(gen/sample (s/gen ::point))



