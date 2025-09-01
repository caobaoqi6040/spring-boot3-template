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
```
