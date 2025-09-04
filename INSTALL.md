# INSTALL

- zulu jdk 17.0.16
- mvn 3.9.11

## git

```shell
git remote add github <repo-link>.git
git push -u github main
git fetch

git ltfs install
git lfs track "soft/**"

git rm --cached -r soft
git add soft

git lfs ls-files
git lfs pull

git checkout -b dev main
git checkout dev
git checkout -d dev
```

# zulu jdk

- linux https://www.azul.com/core-post-download/?endpoint=zulu&uuid=d5bc1e18-e925-447f-82fb-833672c0b318
- windows https://www.azul.com/core-post-download/?endpoint=zulu&uuid=d4ccb483-d243-446d-bdd7-494b54e95076
