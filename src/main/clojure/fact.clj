(defn fact [n]
  (if (< n 1) 1
            (* n (fact (dec n)) )))

{:name "Mike" :sex :male}
(def test-map {:name "Mike"})