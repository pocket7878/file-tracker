# file-tracker

File & Directory update tracker for clojure.

Treating directory contents file update as directory update.

## Usage

    (use 'file-tracker.core)
    (def tracker (file-tracker ["~/Desktop/log-dir" "~/Desktop/workfile.txt"]))
    (tracker) 
    => ()
    ;;Edit workifile.txt
    (tracker)
    => ("~/Desktop/workfile.txt")
    ;;Edit some file inside log-dir
    (tracker)
    => ("~/Desktop/log-dir")

## License

Copyright © 2013 FIXME

Distributed under the Eclipse Public License, the same as Clojure.
