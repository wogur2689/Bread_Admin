/* admin계정 */
insert into users(address, birth_date, email, name, nick_name, password, phone_number, role, user_id, created_at, created_by, updated_at, updated_by)
  values ('서울시', '2000-01-01', 'admin@hyeokbread.co.kr', 'admin', '관리자', '$2a$10$sAqk0.PwY3rIu20BLkFqne7q.N2DmXqa5aFxJWpe23Dz1Y5GM7Kq2', '010-0000-0000', 'admin', 'admin', now(), 'admin', now(), 'admin')