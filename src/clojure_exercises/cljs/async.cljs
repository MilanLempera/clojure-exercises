(ns ^:figwheel-always devfest-workshop-clone.core
  (:require [cljs.core.async :as a])
  (:require-macros [cljs.core.async.macros :refer [go go-loop]]))

(enable-console-print!)

(let [channel (a/chan (a/buffer 2) (map inc))]
     (doseq [n (range 10)]
            (go
              (a/<! (a/timeout (* 2 1000)))
              (a/>! channel n)
              (println "send" n)))

     (js/setTimeout
       #(go
          (println (a/<! channel)))
       3000)

     (js/setTimeout
       #(go
          (println (a/<! channel)))
       4000)

     (js/setTimeout
       #(go
          (println (a/<! channel)))
       5000)

     (js/setTimeout
       #(go
          (while true
                 (println (a/<! channel))))
       5000)
     )

