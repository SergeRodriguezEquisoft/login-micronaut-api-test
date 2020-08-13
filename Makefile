test:
	docker-compose -f docker-compose.test.yml up --build --abort-on-container-exit --exit-code-from login-api --force-recreate