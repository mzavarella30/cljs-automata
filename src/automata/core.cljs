(ns automata.core
  (:require [dommy.core :as dommy :refer-macros [sel sel1]]))

(enable-console-print!)

;;;;;;;;
;; Utils
(defn random-binary
  "Returns a random 0 or 1"
  []
  (rand-int 2))

;;;;;;;;;;;;
;; Constants
(def width 80)

;;;;;;;;;
;; Set up
(defn random-class-div
  []
  (let [el (dommy/create-element "div")
        cl (if (= 0 (random-binary))
             "inactive"
             "active")]
    (dommy/add-class! el cl)))

(defn expand-row
  [row n]
  (doseq [i (range n)]
    (let [el (random-class-div)
          div (sel1 ".row")]
      (dommy/append! div el))))

(expand-row (sel1 ".row") width)

;;;;;;;;;;;;;;;;;;
;; Do the automata

;; duplicate the row

;; process the row

;; repeat
