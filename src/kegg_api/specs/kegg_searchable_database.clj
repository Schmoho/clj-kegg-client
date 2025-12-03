(ns kegg-api.specs.kegg-searchable-database
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            )
  (:import (java.io File)))


(def kegg-searchable-database-data
  {
   })

(def kegg-searchable-database-spec
  (ds/spec
    {:name ::kegg-searchable-database
     :spec kegg-searchable-database-data}))
