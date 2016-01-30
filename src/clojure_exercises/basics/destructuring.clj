(ns clojure-exercises.basics.destructuring)

; by order

(def whole-name ["Katharine" "Bratton"])

(let [[firstname surname] whole-name]
  (println "Firstname:" firstname "\tSurname:" surname))

(let [[first _ third & more] (range 7)]
  (println first third more))

(let [[first :as all] (range 7)]
  (println first all))

; by structure

(def name-object {:firstname "Katharine"
                  :surname   "Bratton"
                  :birthdate {:year  1964
                              :month 11
                              :day   13}})

(let [{firstname :firstname surname :surname :as whole-name} name-object]
  (println "Firstname:" firstname "\tSurname:" surname "->" whole-name))

(let [{:keys [firstname surname]} name-object]
  (println "Firstname:" firstname "\tSurname:" surname))

(let [{:keys [title firstname surname]
       :or   {title "Mgr."}} name-object]
  (println title firstname surname))

(def name-object-with-symbols {'firstname "Katharine" 'surname "from Symbol"})

(let [{:syms [firstname surname]} name-object-with-symbols]
  (println "Firstname:" firstname "\tSurname:" surname))

(def name-object-with-strings {"firstname" "Katharine" "surname" "from String"})

(let [{:strs [firstname surname]} name-object-with-strings]
  (println "Firstname:" firstname "\tSurname:" surname))

; nested

(let [{firstname :firstname {year :year} :birthdate} name-object]
  (println "Firstname:" firstname "\tYear:" year))

; associative

(let [{first 0 second 2} [0 1 2 3]]
  (println first second))