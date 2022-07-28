Buoc1: Install airflow va postgresql
Buoc2: Tao 2 file airflow-scheduler.service va airflow-webserver.service trong /etc/systemd/system
Buoc3: chay lan luot cac cau lenh
    - systemctl daemon-reload
    - sudo systemctl enable airflow-webserver.service
    - sudo systemctl start airflow-webserver.service
    - sudo systemctl start airflow-scheduler.service 
    - check lai trang thai airflow : sudo systemctl status airflow-webserver.service 
