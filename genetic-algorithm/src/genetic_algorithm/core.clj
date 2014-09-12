(ns genetic-algorithm.core
  (:gen-class))

(defstruct city :name :x :y)

;; Ascii map for city name gen
(def ascii-map #(get (vec (map char (range 65 91))) %))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;  Generate city information  ;;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn gen-city-name
  "Adds ascii char to number to identify city"
  [num]
  (if (>= num 26)
    (str (ascii-map (mod num 26)) (gen-city-name (- num 25)))
    (str (ascii-map num))))


(defn gen-random-city-scape
  "Generates num-cities amount of random cities"
  [num-cities dist-x dist-y]
  ;; Create map of randomly generated cities
  (vec (loop [num num-cities
              cities []]
         (if (= num 0)
           cities
           (let [n-num (- num 1)
                 new-city (struct city
                                  (gen-city-name n-num)
                                  (rand-int dist-x)
                                  (rand-int dist-y))
                 n-cities (conj cities new-city)]
             (recur n-num n-cities))))))

(defn scramble-city-order
  "Returns num amount of randomly permuted city routes"
  [num cities]
  (into [] (repeatedly num #(shuffle cities))))

(defn distance-between
  "Finds distance between two cities"
  [city-1 city-2]
  (let [xdist (Math/abs (- (:x city-1) (:x city-2)))
        ydist (Math/abs (- (:y city-1) (:y city-2)))
       ; x (println city-1 " ::: " city-2)
       ; y (println "xdist: " xdist " & ydist: " ydist)
        ]
    (Math/pow (+ (* xdist xdist) (* ydist ydist)) 0.5)))

;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Start of fitness-test ;;
;;;;;;;;;;;;;;;;;;;;;;;;;;;

;; Routes are a vector of cities in which index[0] is first stop, etc

(defn route-distance
  "Finds total distance taken in route"
  [route]
  (loop [current-city route
         next-city (rest route) ;; ensure
         distance 0]
    (if (= (count next-city) 0)
      {:distance distance :route route}
      ;; n --> new
      (let [n-current-city (rest current-city)
            n-next-city (rest next-city)
            n-distance (+ distance (distance-between
                                   (first current-city)
                                   (first next-city)))]
        (recur n-current-city n-next-city n-distance)))))

(defn fitness-test
  "Grabs top N routes"
  [N routes]
  (take N (sort-by :distance routes)))



(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))
